(function() {
    'use strict';

    angular
        .module('app.files')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'files',
                config: {
                    url: '/files',
                    templateUrl: 'app/files/master.html',
                    controller: 'FilesController',
                    controllerAs: 'vm',
                    title: 'Files',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-lock"></i> Files'
                    }
                }
            }
        ];
    }
})();
