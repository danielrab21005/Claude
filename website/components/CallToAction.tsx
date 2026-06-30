"use client";

export default function CallToAction() {
  return (
    <section id="contact" className="py-24 bg-indigo-600">
      <div className="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8 text-center">
        <h2 className="text-3xl sm:text-4xl font-bold text-white mb-4">
          Ready to modernize your giving?
        </h2>
        <p className="text-indigo-200 text-lg mb-10 max-w-2xl mx-auto">
          Join hundreds of houses of worship already using NRS Tap Forward. Start your free 30-day trial — no credit card required.
        </p>

        <form
          className="flex flex-col sm:flex-row gap-3 max-w-lg mx-auto"
          onSubmit={(e) => e.preventDefault()}
        >
          <input
            type="email"
            placeholder="your@church.org"
            className="flex-1 px-4 py-3 rounded-xl text-slate-900 placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-white"
            required
          />
          <button
            type="submit"
            className="bg-white text-indigo-700 font-semibold px-6 py-3 rounded-xl hover:bg-indigo-50 transition-colors whitespace-nowrap"
          >
            Start Free Trial
          </button>
        </form>

        <p className="text-indigo-300 text-sm mt-4">
          30-day free trial · No credit card · Cancel anytime
        </p>
      </div>
    </section>
  );
}
