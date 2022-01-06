function guardarCliente() {
    console.log("ejecutando guardar");

    let cliente = {
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        age: +$("#age").val()
    };

    console.log(cliente);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Client/save",
        //url: "http://localhost:8080/api/Client/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(cliente),
        statusCode: {
            201: function () {
                alert('Se ha registrado un nuevo cliente');
            }
        }
    });


}