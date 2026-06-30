"use client";

import { useState } from "react";
import Link from "next/link";

export default function Navbar() {
  const [open, setOpen] = useState(false);

  return (
    <nav className="fixed top-0 inset-x-0 z-50 bg-white/90 backdrop-blur border-b border-slate-200">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex items-center justify-between h-16">
          <div className="flex items-center gap-2">
            <div className="w-8 h-8 rounded-lg bg-indigo-600 flex items-center justify-center">
              <svg className="w-5 h-5 text-white" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 10V3L4 14h7v7l9-11h-7z" />
              </svg>
            </div>
            <span className="font-bold text-lg text-slate-900">
              NRS <span className="text-indigo-600">Tap Forward</span>
            </span>
          </div>

          <div className="hidden md:flex items-center gap-8">
            <Link href="#features" className="text-sm text-slate-600 hover:text-slate-900 transition-colors">Features</Link>
            <Link href="#how-it-works" className="text-sm text-slate-600 hover:text-slate-900 transition-colors">How It Works</Link>
            <Link href="#pricing" className="text-sm text-slate-600 hover:text-slate-900 transition-colors">Pricing</Link>
            <Link href="#contact" className="text-sm text-slate-600 hover:text-slate-900 transition-colors">Contact</Link>
          </div>

          <div className="hidden md:flex items-center gap-3">
            <a href="#contact" className="text-sm font-medium text-slate-700 hover:text-slate-900 transition-colors">Sign In</a>
            <a href="#contact" className="text-sm font-medium bg-indigo-600 text-white px-4 py-2 rounded-lg hover:bg-indigo-700 transition-colors">
              Get Started
            </a>
          </div>

          <button className="md:hidden p-2 rounded-lg text-slate-600" onClick={() => setOpen(!open)}>
            <svg className="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              {open
                ? <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M6 18L18 6M6 6l12 12" />
                : <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
              }
            </svg>
          </button>
        </div>
      </div>

      {open && (
        <div className="md:hidden border-t border-slate-200 bg-white px-4 py-4 flex flex-col gap-4">
          <Link href="#features" className="text-sm text-slate-600" onClick={() => setOpen(false)}>Features</Link>
          <Link href="#how-it-works" className="text-sm text-slate-600" onClick={() => setOpen(false)}>How It Works</Link>
          <Link href="#pricing" className="text-sm text-slate-600" onClick={() => setOpen(false)}>Pricing</Link>
          <Link href="#contact" className="text-sm text-slate-600" onClick={() => setOpen(false)}>Contact</Link>
          <a href="#contact" className="text-sm font-medium bg-indigo-600 text-white px-4 py-2 rounded-lg text-center">Get Started</a>
        </div>
      )}
    </nav>
  );
}
