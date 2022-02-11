



/* Puedo reusar la misma función para hallar el 
promedio para el caso de los array con un 
múmero de elementos par. El argumento (lista) 
en este caso, será el array de los dos números 
centrales del array (elemento1 y elemento2) */

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
        USANDO DATOS QUEMADOS
 --------------------------------------*/
/* const lista1 = [
    100,
    200,
    500,
    400000000,
];
*/

/* -------------------------------------
        USANDO UNA FUNCIÓN
 --------------------------------------*/

/* Primero uso el método .sort para organizar 
 en orden ascendente los números ingresados 
 por el usuario*/
 function ordenarLista(lista) {
    var numerosOrdenados = lista.sort(function(a,b) {
        return a - b; 
    });
    // console.log(lista);
}

/* Para poder usar el index más adelante para
identificar la posición de la mediana, necesito
convertir en entero (parseInt) todos los valores 
que sean el resultado de dividir la cantidad de 
elementos por dos. De otra manera podría tener
como resultado un float y este no puede ser 
asociado a una posición del array*/
// const mitadLista1 = parseInt(lista1.length / 2);
/* Cuando la cantidad de números que 
tengo en mi array es impar, la mediana
será el múmero del medio. Pero cuando 
tengo una cantidad de elementos par, debo 
crear una función que identifique este caso 
y realice la operación para sacar el promedio
de los dos números centrales del array */
function esPar(numerito) {
    if (numerito % 2 === 0) {
        return true;
    } else {
        return false;
    }
}

let mediana; 

if (esPar(lista1.length)) {
    const elemento1 = lista1[mitadLista1 -1];
    /* Al hallar la posición de la 
    mitad (para arrays con un número 
    para de elementos, puedo simplemento restar
    una posición y automáticamente obtengo el 
    primer número del medio para sacar 
    el promedio. 
    El segundo número sera la mitad de la lista
    ya que con parseInt el número se reondeó hacia
    arriba */
    const elemento2 = lista1[mitadLista1];

    const promedioElemento1y2 = calcularMediaAritmetica([elemento1, elemento2]);

    mediana = promedioElemento1y2;

} else {
    mediana = lista1[mitadLista1];
}