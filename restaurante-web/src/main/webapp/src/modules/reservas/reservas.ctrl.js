(function (ng) {
    var mod = ng.module("reservaModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("reservasContext", "http://localhost:8080/restaurante-web/api/reservas");
    mod.controller('reservasCtrl', ['$scope', '$http', 'reservasContext','$state',
        /*
         * Informacion del reserva obtenida desde el api de reservas para representarla en los records del modulo
         */
        function ($scope, $http, reservasContext, $state) {
            $http.get(reservasContext).then(function (response) { 
                $scope.reservasRecords = response.data;
            });
            $http.get("http://localhost:8080/restaurante-web/api/sucursales").then(function (response) {
                $scope.sucursalesRecords = response.data;
            });
            
            /*
            * Manejo de la reserva con un id especificado por parametro
            * Param: reservaId
            */
            if (($state.params.reservaId !== undefined) && ($state.params.reservaId !== null)) {
                $http.get(reservasContext + '/' + $state.params.reservaId).then(function (response) {
                    $scope.currentReserva = response.data;
                });
            }
        }
    ]);
}
)(window.angular);
 


