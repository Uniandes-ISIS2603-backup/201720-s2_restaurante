(function (ng){
    var mod=ng.module("reservaModule",['ui.router']);
    mod.config(['$stateProvider','urlRouterProvider',
    function($stateProvider,$urlRouterProvider){
        var basePath='src/modules/reservas/';
        $urlRouterProvider.otherwise("/reservasList");
        $stateProvider.state('reservasList',{
            url:'/reservas/list',
            views:{
                'mainView': {
                        templateUrl: basePath + 'reservas.list.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }
            }
        })
    }])
})(window.angular);