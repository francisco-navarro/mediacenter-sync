(function() {
    'use strict';

    angular
        .module('app.files')
        .controller('FilesController', FilesController);

    FilesController.$inject = ['logger'];
    /* @ngInject */
    function FilesController(logger) {
        var vm = this;

        init();

        function init() {
            logger.info('Files controller loaded');
        }
    }
})();
