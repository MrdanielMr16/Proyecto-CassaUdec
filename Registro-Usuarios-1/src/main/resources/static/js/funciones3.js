function eliminar(id) {
	swal({
  title: "Estas seguro de eliminar la cartilla?",
  text: "Una vez eliminado no podras recuperar la informacion de la cartilla!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminarCartillas/"+id,
		successs: function(res){
			console.log(res);
		}
	})
    swal("Tu cartilla se ha eliminado con exito!", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/ListarCartillas";
	}
});
  } else {
    swal("Se ha cancelado el proceso de eliminar!");
  }
});
}