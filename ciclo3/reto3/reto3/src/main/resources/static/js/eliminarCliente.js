function eliminarCliente(identificador) {

    let cliente = {
        id: +identificador
    };

    console.log(cliente);

    $.ajax({
        url: "http://158.101.14.132:8080/admin/client/client",
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