/*
 * This file is part of Android AppStudio [https://github.com/TS-Code-Editor/AndroidAppStudio].
 *
 * License Agreement
 * This software is licensed under the terms and conditions outlined below. By accessing, copying, modifying, or using this software in any way, you agree to abide by these terms.
 *
 * 1. **  Copy and Modification Restrictions  **
 *    - You are not permitted to copy or modify the source code of this software without the permission of the owner, which may be granted publicly on GitHub Discussions or on Discord.
 *    - If permission is granted by the owner, you may copy the software under the terms specified in this license agreement.
 *    - You are not allowed to permit others to copy the source code that you were allowed to copy by the owner.
 *    - Modified or copied code must not be further copied.
 * 2. **  Contributor Attribution  **
 *    - You must attribute the contributors by creating a visible list within the application, showing who originally wrote the source code.
 *    - If you copy or modify this software under owner permission, you must provide links to the profiles of all contributors who contributed to this software.
 * 3. **  Modification Documentation  **
 *    - All modifications made to the software must be documented and listed.
 *    - the owner may incorporate the modifications made by you to enhance this software.
 * 4. **  Consistent Licensing  **
 *    - All copied or modified files must contain the same license text at the top of the files.
 * 5. **  Permission Reversal  **
 *    - If you are granted permission by the owner to copy this software, it can be revoked by the owner at any time. You will be notified at least one week in advance of any such reversal.
 *    - In case of Permission Reversal, if you fail to acknowledge the notification sent by us, it will not be our responsibility.
 * 6. **  License Updates  **
 *    - The license may be updated at any time. Users are required to accept and comply with any changes to the license.
 *    - In such circumstances, you will be given 7 days to ensure that your software complies with the updated license.
 *    - We will not notify you about license changes; you need to monitor the GitHub repository yourself (You can enable notifications or watch the repository to stay informed about such changes).
 * By using this software, you acknowledge and agree to the terms and conditions outlined in this license agreement. If you do not agree with these terms, you are not permitted to use, copy, modify, or distribute this software.
 *
 * Copyright © 2024 Dev Kumar
 */

package com.tscodeeditor.android.appstudio.block.model;

import java.io.Serializable;

public class Event implements Serializable, Cloneable {
  public static final long serialVersionUID = 1L;

  private String name;
  private String title;
  private String description;
  private String rawCode;
  private String eventReplacer;
  private String eventReplacerKey;
  private BlockModel eventTopBlock;
  private int icon;
  private boolean enableEdit;
  private boolean enableRootBlocksDrag;
  private boolean enableRootBlocksValueEditing;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRawCode() {
    return this.rawCode;
  }

  public void setRawCode(String rawCode) {
    this.rawCode = rawCode;
  }

  public String getEventReplacer() {
    return this.eventReplacer;
  }

  public void setEventReplacer(String eventReplacer) {
    this.eventReplacer = eventReplacer;
  }

  public String getEventReplacerKey() {
    return this.eventReplacerKey;
  }

  public void setEventReplacerKey(String eventReplacerKey) {
    this.eventReplacerKey = eventReplacerKey;
  }

  public int getIcon() {
    return this.icon;
  }

  public void setIcon(int icon) {
    this.icon = icon;
  }

  public boolean getEnableEdit() {
    return this.enableEdit;
  }

  public void setEnableEdit(boolean enableEdit) {
    this.enableEdit = enableEdit;
  }

  public boolean getEnableRootBlocksDrag() {
    return this.enableRootBlocksDrag;
  }

  public void setEnableRootBlocksDrag(boolean enableRootBlocksDrag) {
    this.enableRootBlocksDrag = enableRootBlocksDrag;
  }

  public boolean getEnableRootBlocksValueEditing() {
    return this.enableRootBlocksValueEditing;
  }

  public void setEnableRootBlocksValueEditing(boolean enableRootBlocksValueEditing) {
    this.enableRootBlocksValueEditing = enableRootBlocksValueEditing;
  }

  public BlockModel getEventTopBlock() {
    return this.eventTopBlock;
  }

  public void setEventTopBlock(BlockModel eventTopBlock) {
    this.eventTopBlock = eventTopBlock;
  }

  public String getCode() {
    return new String(getRawCode() != null ? getRawCode() : "");
  }

  @Override
  public Event clone() {
    Event event = new Event();
    event.setName(getName() != null ? new String(getName()) : null);
    event.setTitle(getTitle() != null ? new String(getTitle()) : null);
    event.setDescription(getDescription() != null ? new String(getDescription()) : null);
    event.setRawCode(getRawCode() != null ? new String(getRawCode()) : null);
    event.setEventReplacer(getEventReplacer() != null ? new String(getEventReplacer()) : null);
    event.setEventReplacerKey(
        getEventReplacerKey() != null ? new String(getEventReplacerKey()) : null);
    event.setEventTopBlock(getEventTopBlock() != null ? getEventTopBlock().clone() : null);
    event.setIcon(new Integer(getIcon()));
    event.setEnableEdit(new Boolean(getEnableEdit()));
    event.setEnableRootBlocksDrag(new Boolean(getEnableRootBlocksDrag()));
    event.setEnableRootBlocksValueEditing(new Boolean(getEnableRootBlocksValueEditing()));
    return event;
  }
}
