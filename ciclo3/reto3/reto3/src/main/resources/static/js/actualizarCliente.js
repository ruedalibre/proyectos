function actualizarCliente() {
    console.log("ejecutando actualizar");

    let cliente = {
        id: +$("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: +$("#age").val()
    };

    console.log(cliente);

    $.ajax({
        url: "http://158.101.14.132:8080/admin/client/client",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(cliente),
        statusCode: {
            201: function () {
                alert('Se ha actualizado los datos del cliente');
            }
        }
    });


}