// Generated code from Butter Knife. Do not modify!
package com.yohan.examanager.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yohan.examanager.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailFragment_ViewBinding<T extends DetailFragment> implements Unbinder {
  protected T target;

  @UiThread
  public DetailFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.details_title, "field 'title'", TextView.class);
    target.date = Utils.findRequiredViewAsType(source, R.id.details_date, "field 'date'", TextView.class);
    target.duration = Utils.findRequiredViewAsType(source, R.id.details_duration, "field 'duration'", TextView.class);
    target.time = Utils.findRequiredViewAsType(source, R.id.details_time, "field 'time'", TextView.class);
    target.syllabus = Utils.findRequiredViewAsType(source, R.id.details_syllabus, "field 'syllabus'", TextView.class);
    target.eligibility = Utils.findRequiredViewAsType(source, R.id.details_eligibility, "field 'eligibility'", TextView.class);
    target.description = Utils.findRequiredViewAsType(source, R.id.details_description, "field 'description'", TextView.class);
    target.contact = Utils.findRequiredViewAsType(source, R.id.details_contact, "field 'contact'", TextView.class);
    target.marks = Utils.findRequiredViewAsType(source, R.id.details_marks, "field 'marks'", TextView.class);
    target.submit = Utils.findRequiredViewAsType(source, R.id.details_submit, "field 'submit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.title = null;
    target.date = null;
    target.duration = null;
    target.time = null;
    target.syllabus = null;
    target.eligibility = null;
    target.description = null;
    target.contact = null;
    target.marks = null;
    target.submit = null;

    this.target = null;
  }
}
