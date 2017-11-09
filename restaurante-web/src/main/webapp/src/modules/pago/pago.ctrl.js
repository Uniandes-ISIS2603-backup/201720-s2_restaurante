/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("editorialContext", "api/editorials");
    mod.controller('pagoCtrl', ['$scope', '$http', 'editorialContext',
        function ($scope, $http, editorialContext) {
            $http.get('data/pagos.json').then(function (response) {
                $scope.editorialsRecords = response.data;
            });
        }
    ]);
}
)(angular);

