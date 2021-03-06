/*
 * Copyright (c) 2014. Real Time Genomics Limited.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.rtg.vcf.eval;

import java.io.IOException;

import com.rtg.tabix.UnindexableDataException;

public class TrioEvalSynchronizerTest extends AbstractVcfEvalTest {

  public void testInconsistent() throws IOException, UnindexableDataException {
    endToEnd("vcfeval_trio/mie", false,
      "--XXcom.rtg.vcf.eval.custom-variant-factory=parents,sample",
      "--XXcom.rtg.vcf.eval.custom-path-processor=trio",
      "--XXcom.rtg.vcf.eval.prune-no-ops=false",
      "--Xtwo-pass=true",
      "--ref-overlap",
      "--sample=child");
  }

  public void testConsistent() throws IOException, UnindexableDataException {
    endToEnd("vcfeval_trio/ok", false,
      "--XXcom.rtg.vcf.eval.custom-variant-factory=parents,sample",
      "--XXcom.rtg.vcf.eval.custom-path-processor=trio",
      "--XXcom.rtg.vcf.eval.prune-no-ops=false",
      "--Xtwo-pass=true",
      "--ref-overlap",
      "--sample=child");
  }

  protected void endToEnd(String id, boolean expectWarn, String... args) throws IOException, UnindexableDataException {
    endToEnd(id, new String[] {"output.vcf"}, expectWarn, args);
  }
}
