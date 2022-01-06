function actualizarAdmin() {
    console.log("ejecutando actualizar");

    let administrador = {
        id: +$("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val()
    };

    console.log(administrador);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Admin/update",
        //url: "http://localhost:8080/api/Admin/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(administrador),
        statusCode: {
            201: function () {
                alert('Se ha actualizado los datos del administrador');
            }
        }
    });


}