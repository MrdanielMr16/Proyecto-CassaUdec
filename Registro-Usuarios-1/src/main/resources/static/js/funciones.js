function eliminar(id) {
	swal({
  title: "Estas seguro de eliminar el paciente?",
  text: "Una vez eliminado no podras recuperar la informacion del paciente!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminar/"+id,
		successs: function(res){
			console.log(res);
		}
	})
    swal("Tu paciente se ha eliminado con exito!", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/ListarPacientes";
	}
});
  } else {
    swal("Se ha cancelado el proceso de eliminar!");
  }
});
}