package com.example.mdtop;

import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.shape.ShapePath;

/****
 * Project: MD Top
 * From: com.example.mdtop
 * Created by José Zambrano Moya on 12/8/22 at 18:32
 * More info: zambranomoya74@gmail.com
 ****/

public class BottomAppBarCutCornersTopEdge extends BottomAppBarTopEdgeTreatment {

    private final float fabMargin;
    private final float cradleVerticalOffset;

    public BottomAppBarCutCornersTopEdge(
            float fabMargin, float roundedCornerRadius, float cradleVerticalOffset) {
        super(fabMargin, roundedCornerRadius, cradleVerticalOffset);
        this.fabMargin = fabMargin;
        this.cradleVerticalOffset = cradleVerticalOffset;
    }

    @Override
    @SuppressWarnings("RestrictTo")
    public void getEdgePath(float length, float center, float interpolation, ShapePath shapePath) {
        float fabDiameter = getFabDiameter();
        if (fabDiameter == 0) {
            shapePath.lineTo(length, 0);
            return;
        }

        float diamondSize = fabDiameter / 2f;
        float middle = center + getHorizontalOffset();

        float verticalOffsetRatio = cradleVerticalOffset / diamondSize;
        if (verticalOffsetRatio >= 1.0f) {
            shapePath.lineTo(length, 0);
            return;
        }

        shapePath.lineTo(middle - (fabMargin + diamondSize - cradleVerticalOffset), 0);

        shapePath.lineTo(middle, (diamondSize - cradleVerticalOffset + fabMargin) * interpolation);

        shapePath.lineTo(middle + (fabMargin + diamondSize - cradleVerticalOffset), 0);

        shapePath.lineTo(length, 0);
    }
}
