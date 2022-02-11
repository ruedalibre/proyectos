function calcularMediaAritmetica(lista) {
    const sumaLista = lista.reduce(
        function (valorAcumulado = 0, nuevoValor) {
            return valorAcumulado + nuevoValor;
        }
    );
    const promedioLista = sumaLista / lista.length;
    return promedioLista;
}

/* -------------------------------------
        USANDO UNA FUNCIÓN
 --------------------------------------*/

/* Primero uso el método .sort para organizar 
 en orden ascendente los números ingresados 
 por el usuario*/

 function ordenarNumeros(lista) {
    var numerosOrdenados = lista.sort(function(a,b) {
        return a - b; 
    });
    console.log(numerosOrdenados);
 }
    
function esPar(numeros) {
    if (numeros % 2 === 0) {
        return true;
    } else {
        return false;
    };
}

function calcularMediana(listaNumeros) {
    // var listaEnOrden = ordenarNumeros(listaNumeros);
    var numerosOrdenados = listaNumeros.sort(function(a,b) {
        return a - b; 
    });
    
    const mitadLista1 = parseInt(numerosOrdenados.length / 2);
    
    let mediana; 
        if (esPar(numerosOrdenados.length)) {
            const elemento1 = numerosOrdenados[mitadLista1 -1];
            const elemento2 = numerosOrdenados[mitadLista1];
            const promedioElemento1y2 = calcularMediaAritmetica([elemento1, elemento2]);

            mediana = promedioElemento1y2;
        } else {
            mediana = numerosOrdenados[mitadLista1];
        }
        return mediana;
}
