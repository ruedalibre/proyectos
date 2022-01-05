function eliminarMensaje(identificador) {

    let mensaje = {
        id: +identificador
    };

    console.log(mensaje);

    $.ajax({
        url: "http://158.101.14.132:8080/admin/message/message",
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(mensaje),
        statusCode: {
            204: function () {
                alert('Se ha eliminado el mensaje');
                consultarMensajes();
            }
        }
    });

}