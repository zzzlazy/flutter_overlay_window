package flutter.overlay.window.flutter_overlay_window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

public class InputMethodSwitchReceiver extends BroadcastReceiver {

    private static final String TAG = "InputMethodSwitch";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("YOUR_CUSTOM_ACTION")) {
            boolean requestSwitch = intent.getBooleanExtra("REQUEST_SWITCH", false);
            if (requestSwitch) {
                Log.d(TAG, "Received request to switch input method.");
                // Use Handler to delay execution of showInputMethodPicker
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    // Call showInputMethodPicker after a delay
                    showInputMethodPicker(context);
                }, 500); // Delay time in milliseconds
            }
        }
    }

    private void showInputMethodPicker(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.showInputMethodPicker();
        }
    }
}
