package com.craigburke;

import asset.pipeline.AssetCompiler;
import asset.pipeline.AssetFile;

public class JsClosureWrapProcessor {

	public JsClosureWrapProcessor(AssetCompiler precompiler) {}
	
	public String process(String input, AssetFile assetFile) {
		if (assetFile.getMatchedDirectives().contains("wrapped")) {
			return "(function(){\n" + input + "\n})();";
		}
		else {
			return input;
		}
	}

}
