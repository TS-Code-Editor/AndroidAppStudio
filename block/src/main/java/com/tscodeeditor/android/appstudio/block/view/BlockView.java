package com.tscodeeditor.android.appstudio.block.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tscodeeditor.android.appstudio.block.R;
import com.tscodeeditor.android.appstudio.block.editor.EventEditor;
import com.tscodeeditor.android.appstudio.block.model.BlockContentLayerModel;
import com.tscodeeditor.android.appstudio.block.model.BlockModel;

public class BlockView extends LinearLayout {
  private EventEditor editor;
  private Context context;
  private BlockModel blockModel;

  public BlockView(EventEditor editor, Context context, BlockModel blockModel) {
    super(context);
    this.editor = editor;
    this.context = context;
    this.blockModel = blockModel.clone();
    updateBlock();
  }

  public BlockView(EventEditor editor, Context context) {
    super(context);
    this.editor = editor;
    this.context = context;
  }

  public void updateBlock() {
    removeAllViews();
    setOrientation(LinearLayout.VERTICAL);

    if (getBlockModel() == null) return;

    if (getBlockModel().getBlockType() == BlockModel.Type.defaultBlock) {

      /*
       * Add top of blocks as it it define event block.
       */
      if (getBlockModel().isFirstBlock()) {
        LinearLayout firstBlockTop = new LinearLayout(getContext());
        ViewGroup.LayoutParams layoutParams =
            new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        firstBlockTop.setLayoutParams(layoutParams);
        Drawable firstBlockTopDrawable =
            ContextCompat.getDrawable(getContext(), R.drawable.block_first_top);
        firstBlockTopDrawable.setTint(Color.parseColor(getBlockModel().getColor()));
        firstBlockTopDrawable.setTintMode(PorterDuff.Mode.MULTIPLY);
        firstBlockTop.setBackground(firstBlockTopDrawable);
        addView(firstBlockTop);
      }

      /*
       * Add all layers to BlockView.
       */
      for (int layerCount = 0;
          layerCount < getBlockModel().getBlockLayerModel().size();
          ++layerCount) {
        /*
         * Check if current(LOOP) layer is BlockContentLayerModel
         */
        if (getBlockModel().getBlockLayerModel().get(layerCount)
            instanceof BlockContentLayerModel) {
          /*
           * If the block is for defining event then and number of Layout is 1 then:
           * Add LinearLayout with 3 corner cut drawable(Corner Cut: RT:BL:BR).
           */
          if (getBlockModel().getBlockLayerModel().size() == 1 && getBlockModel().isFirstBlock()) {
            LinearLayout layerLayout = new LinearLayout(getContext());
            ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layerLayout.setLayoutParams(layoutParams);
            Drawable layerLayoutDrawable =
                ContextCompat.getDrawable(getContext(), R.drawable.block_default_cut_rt_bl_br);
            layerLayoutDrawable.setTint(Color.parseColor(getBlockModel().getColor()));
            layerLayoutDrawable.setTintMode(PorterDuff.Mode.MULTIPLY);
            layerLayout.setBackground(layerLayoutDrawable);
            addView(layerLayout);
          }
        }
      }
    }
  }

  public EventEditor getEditor() {
    return this.editor;
  }

  public void setEditor(EventEditor editor) {
    this.editor = editor;
  }

  public void setContext(Context context) {
    this.context = context;
  }

  public BlockModel getBlockModel() {
    return this.blockModel;
  }

  public void setBlockModel(BlockModel blockModel) {
    this.blockModel = blockModel.clone();
  }
}
