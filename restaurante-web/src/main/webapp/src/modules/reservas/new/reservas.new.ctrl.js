(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");
    mod.controller('reservaNewCtrl', ['$scope', '$http', 'reservasContext', '$state', '$rootScope',
        function ($scope, $http, reservasContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createReserva = function () {
                $http.post(reservasContext, {
                    
                    fecha: $scope.reservaFecha,
                    mesaId: $scope.reservaMesa
                    
                }).then(function (response) {
                    //Reserva created successfully
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);