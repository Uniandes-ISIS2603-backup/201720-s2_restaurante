(function (ng) {
    var mod = ng.module("reservaModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("reservasContext", "http://localhost:8080/restaurante-web/api/reservas");
    mod.controller('reservaDeleteCtrl', ['$scope', '$http', 'reservasContext', '$state',
        /*
         * Eliminamos una reserva con id especificado por parametro
         * Param: reservaId
         */
        function ($scope, $http, reservasContext, $state) {
            var idReserva = $state.params.reservaId;
            $scope.deleteReserva = function () {
                $http.delete(reservasContext + '/' + idReserva, {}).then(function (response) {
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);