/*const lista1 = [
    1,
    2,
    3,
    1,
    2,
    3,
    4,
    2,
    2,
    2,
    1,
];

Se crea una variable para almacenar 
los valores numéricos como objetos */

// const lista1Count = {};

function CalcularModa(lista1) {
/* Este método itera sobre la lista y 
cada vez que se encuentra con el mismo 
elemento suma una unidad al conteo */
    const lista1Count = {};
    
    lista1.map(
        function (elemento) {
            // if (lista1Count[elemento]) {
            //     lista1Count[elemento] += 1;
            // } else {
            //     lista1Count[elemento] = 1;
            // }
            if (lista1Count[elemento]) {
                    lista1Count[elemento] += 1;
                } else {
                    lista1Count[elemento] = 1;
            }
        }
    );
    /* Para identificar el valor que más veces se repite 
    puedo volver a convertir la lista de objetos en un 
    array con el método Object.entries y, una vez convertido 
    de nuevo en array, puedo aplicarle el método sort*/
    // const list1Array = Object.entries(lista1Count).sort(
        /* El método sort organiza los elementos para 
        poder encontrar el valor más alto del array */
        /* Este métodoLa genera unA lista de arrays */
        // function (elementoA, elementoB) {
            /* Ahora debo acceder al valor de cada 
            array que es el que indica la cantidad 
            de veces que está repetido un elemento */
            /* Esta función organiza los elementos 
            en orden ascendente de acuerdo al resultado
            de la resta de los números sobre los cuales 
            va iterando. Si el primer valor es mayor que 
            el segundo, el numero es (+) y lo envía al final
            de la lista; si el igual, es = 0 y lo deja 
            en su posicón; y si es menor es (-) , lo envía 
            a una posición anterior */
    //         return elementoA[1] - elementoB[1];
    //     }
    // );
    const lista1Array = Object.entries(lista1Count).sort(
        function (elementoA, elementoB) {
            return elementoA[1] - elementoB[1];
        }
    );
    const moda = lista1Array[lista1Array.length -1];
    return moda; 
}
/* Un vez organizada la lista, puedo acceder al 
valor más alto llamando al valor último de la lista
pero debo restarle una unidad porque el conteo de 
las posiciones del array comienza en cero, no en uno */
// const moda = list1Array[lista1Array.length -1];


