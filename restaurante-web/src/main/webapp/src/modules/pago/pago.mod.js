/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    // Definición del módulo
    var mod = ng.module("mesaModule", ['ui.router']);

    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/pago/';
            // Mostrar la lista de editoriales será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/pagoList");
            // Definición del estado 'editorialsList' donde se listan los editoriales
            $stateProvider.state('pagoList', {
                // Url que aparecerá en el browser
                url: 'pago/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'pago.list.html',
                        controller: 'pagoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

