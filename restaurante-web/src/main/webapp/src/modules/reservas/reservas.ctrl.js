(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");
    mod.controller('reservasCtrl', ['$scope', '$http', 'reservasContext',
        function ($scope, $http, reservaContext) {
            $http.get('data/reservas.json').then(function (response) { 
                $scope.reservasRecords = response.data;
            });
        }
    ]);
}
)(angular);
 


