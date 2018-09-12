package Components;

public class ElementsFactory {
    
    Elements headlineElement = new Elements(
                 "headline",
                 "[id*=\"tmp_headline\"][class*=\"element-col\"]",
                 ".headline-item",
                 ".headline-wrapper-inn",
                 ".icon-element-header"
         );
    Elements paragraphElement = new Elements(
            "paragraph",
            "[id*=\"tmp_text\"][class*=\"element-col\"]",
            ".text-item",
            ".text-block-editor-p",
            ".icon-element-paragraph"
    );
    Elements imageElement = new Elements(
            "image",
            "[id*=\"tmp_image\"][class*=\"element-col\"]",
            ".image-item-inn img",
            ".imageloader img",
            ".icon-element-image"
    );
    Elements videoElement = new Elements(
            "video",
            "[id*=\"tmp_video\"][class*=\"element-col\"]",
            ".video-player-style",
            ".iframe-div",
            ".icon-element-video"
    );



}
