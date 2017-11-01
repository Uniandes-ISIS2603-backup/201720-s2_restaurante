(function (ng) {
    var mod = ng.module("restauranteModule");
    mod.constant("restaurantesContext", "api/restaurantes");
    mod.controller('restauranteCtrl', ['$scope', '$http', 'restaurantesContext', '$state',
        function ($scope, $http, restaurantesContext, $state) {
            $http.get(restaurantesContext).then(function (response) {
                $scope.authorsRecords = response.data;
            });

            if ($state.params.restauranteId !== undefined) {
                $http.get(restaurantesContext + '/' + $state.params.restauranteId).then(function (response) {
                    $scope.currentRestaurante = response.data;
                });
            }
        }
    ]);
}
)(angular);