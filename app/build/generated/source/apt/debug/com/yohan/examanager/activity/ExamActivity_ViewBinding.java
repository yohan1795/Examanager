// Generated code from Butter Knife. Do not modify!
package com.yohan.examanager.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yohan.examanager.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExamActivity_ViewBinding<T extends ExamActivity> implements Unbinder {
  protected T target;

  private View view2131755199;

  @UiThread
  public ExamActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.exam_submit, "method 'submit'");
    view2131755199 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (this.target == null) throw new IllegalStateException("Bindings already cleared.");

    view2131755199.setOnClickListener(null);
    view2131755199 = null;

    this.target = null;
  }
}
