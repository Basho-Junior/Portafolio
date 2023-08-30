package com.example.practica11.servicio;

import com.example.practica11.entidades.Rol;
import com.example.practica11.entidades.Usuario;
import com.example.practica11.entidades.repositorios.RolRepo;
import com.example.practica11.entidades.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private UsuarioRepo usuarioRepository;

    @Autowired
    private RolRepo rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    /**
     * Creando el usuario por defecto y su rol.
     */
    public void crearUsuarioAdmin(){
        // Devolver si ya existe el usuario admin
        if (usuarioRepository.findByUsername("admin") != null) {
            return;
        }

        System.out.println("Creación del usuario y rol en la base de datos");

        Rol rolAdmin = new Rol("ROLE_ADMIN");

        rolRepository.save(rolAdmin);
        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setNombre("Administrador");
        admin.setActivo(true);
        admin.setRol("ROLE_ADMIN");
        admin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));

        usuarioRepository.save(admin);
    }
    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActivo(), true, true, true, grantedAuthorities);
    }
}
