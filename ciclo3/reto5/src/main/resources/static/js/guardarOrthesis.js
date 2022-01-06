function guardarOrthesis() {
    console.log("ejecutando guardar");

    $.ajax({
        url: "http://158.101.14.132:8080/api/Category/all",
        //url: "http://localhost:8080/api/Category/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            buscarId(respuesta);
        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        }
    });

    function buscarId(categorias) {
        var arr = categorias;
        categoria = { id: "", name: "", description: "", ortopedics: "" };
        const keys = Object.keys(categoria);
        console.log(keys);

        arr.forEach((Element) => {
            console.log(Element.name);

            var txt = (Element.name);
            console.log(txt);

            var cat = document.getElementById("select").value;
            console.log(cat);

            if (txt === cat) {
                var codigoCatSelected = Element.id;
                let idCat = codigoCatSelected;
                console.log(codigoCatSelected + "codigo");
                console.log(idCat + "codigo a registrar");
                guardar(idCat);

            }

        });

    }

    function guardar(codigoCategoria) {

        console.log("consulta categorias");
        console.log(codigoCategoria);

        let ortopedics = {
            //id: +$("#id").val(),
            brand: $("#brand").val(),
            year: $("#year").val(),
            name: $("#name").val(),
            description: $("#description").val(),
            category: { "id": codigoCategoria }
        };

        console.log(ortopedics);
        console.log("creacion ortesis");
        $.ajax({
            url: "http://158.101.14.132:8080/api/Ortopedic/save",
            //url: "http://localhost:8080/api/Ortopedic/save",
            type: 'POST',
            dataType: 'json',
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            data: JSON.stringify(ortopedics),
            statusCode: {
                201: function () {
                    alert('Se ha registrado la orthesis');
                }
            }
        });
    }


}