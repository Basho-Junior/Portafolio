
function agregaform(datos){

	d=datos.split('||');

	$('#recipient-code').val(d[0]);
	$('#recipient-name').val(d[1]);
	$('#recipient-price').val(d[2]);
	$('#recipient-quantity').val(d[3]);
	$('#recipient-category').val(d[4]);
	
}
function agregaform2(datos2){

	d2=datos2.split('||');

	$('#recipient-id').val(d2[0]);
	$('#recipient-nombre').val(d2[1]);
	$('#recipient-cantidad').val(d2[2]);
	$('#recipient-total').val(d2[3]);
	
}
