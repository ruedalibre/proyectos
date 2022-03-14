
const kilometrosHoraPorTramo = [
    {
        horas: 3, 
        kilometros: 23
    },
    {
        horas: 5, 
        kilometros: 140
    },
    {
        horas: 0.5,
        kilometros: 549
    },
    {
        horas: 0.33,
        kilometros: 987
    }
]; 

const kilometrosPorHoraInv = kilometrosHoraPorTramo.map(function (kmHoraObject) {
 return kmHoraObject.horas  / kmHoraObject.kilometros;
});

const sumValoresInvertidos = kilometrosPorHoraInv.reduce(
    function (sum = 0, nuevoValor) {
        return sum + nuevoValor;
    }
);

const mediaArmonica = [kilometrosHoraPorTramo.length -1] / sumValoresInvertidos;