// Función para registrar nuevo administrador
function guardarAdministrador() {
    console.log("ejecutando guardar");

    let administrador = {
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val()

    };

    console.log(administrador);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Admin/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(administrador),
        statusCode: {
            201: function () {
                alert('Se ha registrado un nuevo administrador');
            }
        }
    });


}