/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.serviceregistry.version;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mockit.Deencapsulation;

public class TestVersionUtils {
  @Before
  public void setup() {
    Deencapsulation.setField(VersionUtils.class, "versionCache", new ConcurrentHashMap<>());
  }

  @After
  public void teardown() {
    Deencapsulation.setField(VersionUtils.class, "versionCache", new ConcurrentHashMap<>());
  }

  @Test
  public void getOrCreate() {
    Version v = VersionUtils.getOrCreate("1.0.0");

    Assert.assertEquals("1.0.0", v.getVersion());
    Assert.assertSame(v, VersionUtils.getOrCreate("1.0.0"));
  }
}
