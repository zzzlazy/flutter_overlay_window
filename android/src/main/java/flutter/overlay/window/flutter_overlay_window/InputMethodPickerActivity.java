package flutter.overlay.window.flutter_overlay_window;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;

public class InputMethodPickerActivity extends Activity {

    private boolean didShowInputMethodPicker = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 0.2秒后显示输入法选择器
        getWindow().getDecorView().postDelayed(() -> {
            InputMethodManager inputMethodManager = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            }
            if (inputMethodManager != null) {
                inputMethodManager.showInputMethodPicker();
            }
            didShowInputMethodPicker = true;
        }, 200);

        // 点击任意位置关闭
        getWindow().getDecorView().setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && didShowInputMethodPicker) {
            finish();
        }
    }
}
