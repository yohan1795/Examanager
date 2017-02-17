// Generated code from Butter Knife. Do not modify!
package com.yohan.examanager.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yohan.examanager.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyExamsFragment_ViewBinding<T extends MyExamsFragment> implements Unbinder {
  protected T target;

  @UiThread
  public MyExamsFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.examRecyclerView = Utils.findRequiredViewAsType(source, R.id.exam_recycler, "field 'examRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.examRecyclerView = null;

    this.target = null;
  }
}
