function eliminar(id) {
	swal({
  title: "Estas seguro de eliminar el evento?",
  text: "Una vez eliminado no podras recuperar la informacion del evento!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminarEventos/"+id,
		successs: function(res){
			console.log(res);
		}
	})
    swal("Tu evento se ha eliminado con exito!", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/ListarEventos";
	}
});
  } else {
    swal("Se ha cancelado el proceso de eliminar!");
  }
});
}