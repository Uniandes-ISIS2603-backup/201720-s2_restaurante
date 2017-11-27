(function (ng) {
    var mod = ng.module("restauranteModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("restaurantesContext", "api/restaurantes");
    mod.controller('restauranteCtrl', ['$scope', '$http', 'restaurantesContext', '$state',
        /*
         * Informacion del restaurante obtenida desde el api de domicilios para representarla en los records del modulo
         */
        function ($scope, $http, restaurantesContext, $state) {
            $http.get('http://localhost:8080/restaurante-web/api/sucursales').then(function (response) {
                $scope.restaurantesRecords = response.data;
            });

            /*
            * Manejo del restaurante con un id especificado por parametro
            * Param: restauranteId
            */
            if ($state.params.restauranteId !== undefined) {
                $http.get(restaurantesContext + '/' + $state.params.restauranteId).then(function (response) {
                    $scope.currentRestaurante = response.data;
                });
            }
        }
    ]);
}
)(angular);