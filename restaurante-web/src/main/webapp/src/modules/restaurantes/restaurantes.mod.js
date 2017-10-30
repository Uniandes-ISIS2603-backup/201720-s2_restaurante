/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng){
    var mod=ng.module("restauranteModule",['ui.router']);
    mod.config(['$stateProvider','$urlRouterProvider',
    function($stateProvider,$urlRouterProvider){
        var basePath='src/modules/restaurantes/';
        $urlRouterProvider.otherwise("/restaurantesList");
        $stateProvider.state('restaurantesList',{
            url:'/restaurantes/list',
            views:{
                'mainView': {
                        templateUrl: basePath + 'restaurantes.list.html',
                        controller: 'restauranteCtrl',
                        controllerAs: 'ctrl'
                     }
                }
            }).state('restaurantesDetail', {
                url: '/detail',
                parent: 'restaurantes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'restaurantes.list.html'
                    }
                }
            });
        }]);
})(window.angular);