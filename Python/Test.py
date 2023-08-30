from kivy.app import App
from kivy.uix.scatter import Scatter
from kivy.uix.button import Button
from kivy.uix.label import Label
from kivy.uix.floatlayout import FloatLayout
from kivy.uix.textinput import TextInput
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.image import Image
from kivy.uix.widget import Widget
from kivy.core.audio import SoundLoader
import os

sound = SoundLoader.load('videoplayback.wav')
if sound:
    print("Sound found at %s" % sound.source)
    print("Sound is %.3f seconds" % sound.length)
    sound.play()


class primerboton(App):
    def __init__(self):
        super(primerboton, self).__init__()
        self.btn = Button(text="Start")
        self.btn2 = Button(text="Exit")
        self.lbl = Label(text="In The Darkness")
        self.imagen = Image(source='The-7-Steps-of-eLearning-Course-Preparation-Process-816x540.png')
    def build(self):
        self.btn.bind(on_press=self.clk)
        self.btn2.bind(on_press=self.clk2)
        layout = BoxLayout()
        layout.orientation = 'vertical'
        layout.add_widget(self.imagen)
        layout.add_widget(self.lbl)
        layout.add_widget(self.btn)
        layout.add_widget(self.btn2)
        return layout
                       
    def clk(self, obj):
        if self.btn.text == "Start":
            self.lbl.text = "Estas atrapado en un cuarto sin luz y hay dos puertas.Cual eliges?"
            self.imagen.source = 'fa25edfb84607a352d0a1b3f3a6337f7.png'
            self.btn.text = "Derecha"
            self.btn2.text = "Izquierda"
            self.btn.bind(on_press=self.clk3)
    def clk3(self, obj):
        if self.btn.text == "Derecha":
            self.lbl.text = "Entras en una habitacion y se cierra la puerta pero sientes a alguien.Que haces?"
            self.imagen.source = 'ss_dark-room-door-opening.png'
            self.btn.text = "Volver"
            self.btn2.text = "Correr"
            self.btn.bind(on_press=self.clk4)
    def clk4(self, obj):
        if self.btn.text == "Volver":
            self.imagen.source = 'scary_face_by_angelicab.png'
            self.lbl.text = "Moriste"
    def clk2(self, obj):
        if self.btn2.text == "Exit":
            exit(0)
        if self.btn2.text == "Izquierda":
            self.imagen.source = 'scary_face_by_angelicab.png'
            self.lbl.text = "Moriste"
        if self.btn2.text == "Correr":
            self.imagen.source = 'rundark1.png'
            self.lbl.text = "Ganaste"
        
if __name__ == "__main__":
    primerboton().run()





