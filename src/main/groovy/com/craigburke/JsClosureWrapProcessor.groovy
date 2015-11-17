package com.craigburke

import asset.pipeline.AbstractProcessor
import asset.pipeline.AssetCompiler
import asset.pipeline.AssetFile
import asset.pipeline.AssetPipelineConfigHolder

class JsClosureWrapProcessor extends AbstractProcessor {

    JsClosureWrapProcessor(AssetCompiler precompiler) {
        super(precompiler)
    }

    String process(String input, AssetFile assetFile) {

        if (assetFile.matchedDirectives.contains('wrapped') || input.startsWith('//= wrapped')) {
            Map config = (Map)AssetPipelineConfigHolder.config?.jsWrap ?: [:]
            boolean useStrict = config.containsKey('useStrict') ? config.useStrict : true
            "(function(){\n${useStrict ? "'use strict';\n" : ''}${input}})();"
        } else {
            input
        }

    }

}
