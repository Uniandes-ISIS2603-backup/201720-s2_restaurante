(function (ng) {
    var mod = ng.module("reservaModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("reservasContext", "http://localhost:8080/restaurante-web/api/reservas");
    mod.controller('reservaNewCtrl', ['$scope', '$http', 'reservasContext', '$state', '$rootScope',
        function ($scope, $http, reservasContext, $state, $rootScope) {
            $rootScope.edit = false;
            /*
             * Funcion para crear una nuevo reserva a partir de los parametros definidos en el back
             */
            $scope.createReserva = function () {
                $http.post(reservasContext, {
                    
                    fecha: $scope.reservaFecha,
                    idMesa: $scope.reservaMesa,
                    dirSuc: $scope.sucursal
                    
                }).then(function (response) {
                    //Reserva created successfully
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);