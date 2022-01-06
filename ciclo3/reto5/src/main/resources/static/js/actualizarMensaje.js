function actualizarMensaje() {
    console.log("ejecutando actualizar mensaje");

    let mensaje = {
        idMessage: +$("#idMessageact").val(),
        messageText: $("#messagetextact").val()
    };

    console.log(mensaje);

    $.ajax({
        // Cambiar dirección para reto
        url: "http://158.101.14.132:8080/api/Message/update",
        //url: "http://localhost:8080/api/Message/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(mensaje),
        statusCode: {
            201: function () {
                alert('Se ha actualizado el mensaje');
            }
        }
    });


}