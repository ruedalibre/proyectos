function eliminarAdmin(identificador) {

    $.ajax({
        url: "http://158.101.14.132:8080/api/Admin/" + identificador,
        //url: "http://localhost:8080/api/Admin/"+identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(identificador),
        statusCode: {
            204: function () {
                alert('Se ha eliminado el administrador');
                consultarAdministrador();
            }
        }
    });

}