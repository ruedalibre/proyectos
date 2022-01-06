// Función para registrar nueva categoria
function guardarCategoria() {
    console.log("ejecutando guardar");

    let categoria = {
        name: $("#name").val(),
        description: $("#description").val()
    };
    console.log(categoria);
    $.ajax({
       url: "http://158.101.14.132:8080/api/Category/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(categoria),
        statusCode: {
            201: function () {
                alert('Se ha registrado una nueva categoria');
            }
        }
    });


}