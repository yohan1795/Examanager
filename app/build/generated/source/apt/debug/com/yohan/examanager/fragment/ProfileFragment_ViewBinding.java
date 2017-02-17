// Generated code from Butter Knife. Do not modify!
package com.yohan.examanager.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yohan.examanager.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileFragment_ViewBinding<T extends ProfileFragment> implements Unbinder {
  protected T target;

  private View view2131755289;

  private View view2131755290;

  @UiThread
  public ProfileFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.aadharNo = Utils.findRequiredViewAsType(source, R.id.profile_aadhar_no_box, "field 'aadharNo'", EditText.class);
    target.contactNo = Utils.findRequiredViewAsType(source, R.id.profile_contact_no_box, "field 'contactNo'", EditText.class);
    target.name = Utils.findRequiredViewAsType(source, R.id.profile_name_box, "field 'name'", EditText.class);
    target.id = Utils.findRequiredViewAsType(source, R.id.profile_id_box, "field 'id'", EditText.class);
    target.gender = Utils.findRequiredViewAsType(source, R.id.profile_gender_box, "field 'gender'", EditText.class);
    target.dob = Utils.findRequiredViewAsType(source, R.id.profile_dob_box, "field 'dob'", EditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.profile_email_box, "field 'email'", EditText.class);
    view = Utils.findRequiredView(source, R.id.profile_edit, "field 'edit' and method 'doEdit'");
    target.edit = Utils.castView(view, R.id.profile_edit, "field 'edit'", Button.class);
    view2131755289 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.doEdit();
      }
    });
    view = Utils.findRequiredView(source, R.id.profile_save, "field 'save' and method 'doSave'");
    target.save = Utils.castView(view, R.id.profile_save, "field 'save'", Button.class);
    view2131755290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.doSave();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.aadharNo = null;
    target.contactNo = null;
    target.name = null;
    target.id = null;
    target.gender = null;
    target.dob = null;
    target.email = null;
    target.edit = null;
    target.save = null;

    view2131755289.setOnClickListener(null);
    view2131755289 = null;
    view2131755290.setOnClickListener(null);
    view2131755290 = null;

    this.target = null;
  }
}
