function actualizarCalificacion() {
    console.log("ejecutando actualizar");

    let calificacion = {
        id: $("#id").val(),
        score: $("#score").val(),
        message: $("#message").val()

    };

    console.log(calificacion);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Score/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(calificacion),
        statusCode: {
            201: function () {
                alert('Se ha actualizado los datos de la calificacion');
            }
        }
    });


}