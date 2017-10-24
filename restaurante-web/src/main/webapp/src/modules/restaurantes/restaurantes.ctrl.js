(function (ng) {
    var mod = ng.module("restauranteModule");
    mod.constant("restauranteContext", "api/restaurantes");
    mod.controller('restauranteCtrl', ['$scope', '$http', 'editorialContext',
        function ($scope, $http, restauranteContext) {
            $http.get('data/editorials.json').then(function (response) {
                $scope.restaurantesRecords = response.data;
            });
        }
    ]);
}
)(windows.angular);