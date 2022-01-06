function eliminarCliente(identificador) {
    let cliente = {
        idClient: +identificador
    };

    console.log(cliente);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Client/" + identificador,
        //url: "http://localhost:8080/api/Client/"+identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(cliente),
        statusCode: {
            204: function () {
                alert('Se ha eliminado los datos del cliente');
                consultarCliente();
            }
        }
    });

}