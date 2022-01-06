// Función para actualizar mensaje
function actualizarMensaje() {
    console.log("ejecutando actualizar mensaje");

    let mensaje = {
        id: +$("#id").val(),
        messagetext: $("#messagetext").val()
    };

    console.log(mensaje);

    $.ajax({
        url: "http://158.101.14.132:8080/admin/message/message",
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