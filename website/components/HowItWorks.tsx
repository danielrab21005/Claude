const steps = [
  {
    number: "01",
    title: "Set Up Your Organization",
    description: "Create your church profile in minutes. Add your logo, set up giving funds (Tithe, Building, Missions), and invite your team members with role-based permissions.",
  },
  {
    number: "02",
    title: "Install the Android App",
    description: "Download NRS Tap Forward on any Android phone or tablet. The app works as a full POS terminal — tap the screen, tap a card, or scan a QR code to accept giving.",
  },
  {
    number: "03",
    title: "Collect & Track Giving",
    description: "Every transaction is recorded in real time on your dashboard. View totals by fund, by giver, or by service. Your finance team always has accurate, up-to-date records.",
  },
  {
    number: "04",
    title: "Manage Events & Members",
    description: "Schedule services and events from the web portal. Members can RSVP, check in via the app, and receive automatic reminders — all tracked in your member directory.",
  },
];

export default function HowItWorks() {
  return (
    <section id="how-it-works" className="py-24 bg-slate-50">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="text-center mb-16">
          <p className="text-indigo-600 font-semibold text-sm uppercase tracking-widest mb-3">Simple Setup</p>
          <h2 className="text-3xl sm:text-4xl font-bold text-slate-900 mb-4">Up and running in under an hour</h2>
          <p className="max-w-xl mx-auto text-slate-500 text-lg">
            No IT department needed. If you can use a smartphone, you can run NRS Tap Forward.
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
          {steps.map((step, i) => (
            <div key={step.number} className="relative bg-white rounded-2xl p-8 border border-slate-200 shadow-sm">
              <div className="flex items-start gap-5">
                <div className="text-4xl font-black text-indigo-100 leading-none select-none">{step.number}</div>
                <div>
                  <h3 className="font-bold text-slate-900 text-lg mb-2">{step.title}</h3>
                  <p className="text-slate-500 text-sm leading-relaxed">{step.description}</p>
                </div>
              </div>
              {i < steps.length - 1 && (
                <div className="hidden md:block absolute -right-4 top-1/2 -translate-y-1/2 z-10">
                  {i % 2 === 0 && (
                    <svg className="w-8 h-8 text-indigo-300" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 5l7 7-7 7" />
                    </svg>
                  )}
                </div>
              )}
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
