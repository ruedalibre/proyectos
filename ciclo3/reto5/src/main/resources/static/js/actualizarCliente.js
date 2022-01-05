function actualizarCliente() {
    console.log("ejecutando actualizar");

    let cliente = {
        idClient: +$("#idClient").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: +$("#age").val(),
        password: $("#password").val()
    };

    console.log(cliente);

    $.ajax({
        // Cambiar dirección para reto
        url: "http://158.101.14.132:8080/api/Client/update",
        //url: "http://localhost:8080/api/Client/update",
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